package hu.bme.aut.android.spotifydemo.mock;

import java.io.IOException;

import hu.bme.aut.android.spotifydemo.model.Token;
import hu.bme.aut.android.spotifydemo.network.TokenApi;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockTokenApi implements TokenApi {

    @Override
    public Call<Token> getToken(String grantType, String authorisation) {
        final Token token = new Token();
        token.setAccessToken("234234234234244234234adasdasdasdasdasd234234234234");
        token.setTokenType("test");
        token.setExpiresIn(1234567);


        Call<Token> call = new Call<Token>() {
            @Override
            public Response<Token> execute() throws IOException {
                return Response.success(token);
            }

            @Override
            public void enqueue(Callback<Token> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Token> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

}
