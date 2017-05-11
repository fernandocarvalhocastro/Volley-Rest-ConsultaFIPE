package fiap.com.br.fipe;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by logonrm on 11/05/2017.
 */

public class RequestError implements Response.ErrorListener {

    private ImageView imgLoading;

    public RequestError(ImageView imgLoading) {
        this.imgLoading = imgLoading;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("FIPE", "Erro: " + error.getMessage());
        imgLoading.setVisibility(View.INVISIBLE);
    }
}
