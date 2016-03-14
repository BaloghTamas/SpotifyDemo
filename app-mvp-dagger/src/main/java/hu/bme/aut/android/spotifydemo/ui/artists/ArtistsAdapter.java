package hu.bme.aut.android.spotifydemo.ui.artists;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import hu.bme.aut.android.spotifydemo.R;
import hu.bme.aut.android.spotifydemo.model.Item;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ViewHolder> {

	private Context context;
	private List<Item> artistsList;

	public ArtistsAdapter(Context context, List<Item> artistsList) {
		this.context = context;
		this.artistsList = artistsList;
	}

	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View itemView = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.card_artist, viewGroup, false);
		return new ViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		Item artist = artistsList.get(position);
		if (artist.getImages().size() > 0) {
			Glide.with(context).load(artist.getImages().get(0).getUrl()).into(holder.ivImage);
		}
		holder.tvName.setText(artist.getName());
		holder.tvPopularity.setText(artist.getPopularity().toString());
	}

	@Override
	public int getItemCount() {
		return artistsList.size();
	}

	protected static class ViewHolder extends RecyclerView.ViewHolder {
		public ImageView ivImage;
		public TextView tvName;
		public TextView tvPopularity;

		public ViewHolder(View itemView) {
			super(itemView);
			ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
			tvName = (TextView) itemView.findViewById(R.id.tvName);
			tvPopularity = (TextView) itemView.findViewById(R.id.tvPopularity);
		}
	}
}
