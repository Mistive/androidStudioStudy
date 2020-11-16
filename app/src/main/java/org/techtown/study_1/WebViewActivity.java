package org.techtown.study_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://m.naver.com";   //불러올 url을 저장

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);   //javascript를 허용
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());  //크롬에서 실행 최적화
        webView.setWebViewClient(new WebViewClientClass());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { //keyEventListener
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
                }

private class WebViewClientClass extends WebViewClient {
    //현재 페이지의 url을 읽어올 수 있는 method(새창, 특정 페이지에서 특정 기능 구현 등)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(url);
        return true;
    }
}
}