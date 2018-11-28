package crp.com.dependency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import crp.com.viewtools.Demo;

public class MainActivity extends AppCompatActivity {

    String cc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Demo k=new Demo();

        cc=k.nameChange("KK");
        Log.e("Loss",cc
        );

        Toast.makeText(this, cc, Toast.LENGTH_SHORT).show();
    }
}
