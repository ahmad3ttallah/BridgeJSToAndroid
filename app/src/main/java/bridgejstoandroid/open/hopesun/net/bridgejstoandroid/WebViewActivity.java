package bridgejstoandroid.open.hopesun.net.bridgejstoandroid;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends Activity {

	private WebView webView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);

		webView = (WebView) findViewById(R.id.webView);

		String customHtml = "<html>" +
							"<body>" +
							"    Lets say that is the score value:" +
							"	 <br/><input type='text' id='scoreValue' placeholder='Put the score'>" +
							"    <br/><button onclick=\"clickAction()\">Click me to Toast the value</button>" +
							"    <script>" +
							"    function clickAction() {" +
							"        WebAppInterface.showToast(document.getElementById('scoreValue').value);" +
							"    };" +
							"    </script>" +
							"</body>" +
							"</html>";
		WebAppInterface WebAppInterface = new WebAppInterface(this);
		webView.setWebViewClient(new WebViewClient());
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadData(customHtml, "text/html", "UTF-8");
		webView.addJavascriptInterface(WebAppInterface, "WebAppInterface");
	}
	
	public class WebAppInterface {
	    Context mContext;

	    /** Instantiate the interface and set the context */
	    WebAppInterface(Context c) {
	        mContext = c;
	    }

	    /** Show a toast from the web page */
		@JavascriptInterface
	    public void showToast(String toast) {
	        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
	    }
	}

}