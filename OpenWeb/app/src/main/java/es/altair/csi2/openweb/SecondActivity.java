package es.altair.csi2.openweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class SecondActivity extends AppCompatActivity {

    private WebView website;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        website = (WebView) findViewById(R.id.website);
        progress = (ProgressBar) findViewById(R.id.progress);

        // Para usar el webView como navagador y no abre el navegador por defecto
        website.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }
        });


        String url = getIntent().getStringExtra("web");

        //  Activar Javascript
        website.getSettings().setJavaScriptEnabled(true);

        //  Permitir zoom en la web con lo botones
        //website.getSettings().setBuiltInZoomControls(true);

        //  Permitir zoom con los dedos
        website.getSettings().setSupportZoom(true);

        //  Para ocultar las barras del scroll
        website.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

        //
        website.setWebChromeClient(new WebChromeClient() {

            // onprogres... intro
            //  Tiempo que está tardando en cargar la url
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progress.setVisibility(View.VISIBLE);
                progress.setProgress(newProgress);
                if (newProgress == 100)
                    progress.setVisibility(View.GONE);
            }
        });

        website.loadUrl("http://" + url);
    }

    @Override
    public void onBackPressed() {
        if(website.canGoBack()){
            website.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}
