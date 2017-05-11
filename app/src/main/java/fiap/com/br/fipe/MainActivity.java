package fiap.com.br.fipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    private Spinner spMarca;
    private ArrayAdapter<Marca> adpMarca;
    private ImageView imgLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spMarca = (Spinner)findViewById(R.id.spMarca);
        imgLoading = (ImageView)findViewById(R.id.imgLoading);
        imgLoading.setVisibility(View.VISIBLE);
        carregarMarcar();
    }

    private void carregarMarcar() {
        String urlTXT = "http://fipeapi.appspot.com/api/1/carros/marcas.json";

        JsonArrayRequest req = new JsonArrayRequest(urlTXT,
                                            new RequestMarca(spMarca, adpMarca, this, imgLoading), new RequestError(imgLoading));
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(req);

    }
}
