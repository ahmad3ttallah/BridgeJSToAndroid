package bridgejstoandroid.open.hopesun.net.bridgejstoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class BridgeJSToAndroid extends AppCompatActivity {

    private Button goToWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridge_js_to_android);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        goToWebView = (Button) findViewById(R.id.goToWebView);

        goToWebView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(BridgeJSToAndroid.this, WebViewActivity.class);
                startActivity(intent);
            }

        });
    }
}
