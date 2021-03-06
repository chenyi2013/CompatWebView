package com.sw.compat.webview;


import android.os.Build;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * CompatWebViewClient用于将低于api17的消息转发给CompatWebView
 *
 * @author shiwang
 */
public class CompatWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Build.VERSION.SDK_INT < 17) {
            if (view instanceof CompatWebView) {
                if (((CompatWebView) view).shouldOverrideUrlLoading(url)) {
                    return true;
                }
            }
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (Build.VERSION.SDK_INT < 17) {
            if (view instanceof CompatWebView) {
                ((CompatWebView) view).onPageFinished();
            }
        }

    }
}
