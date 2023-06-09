package kr.co.company.imagedisp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
        Matrix m = new Matrix();
        m.preScale(-1, 1);

        Bitmap b = BitmapFactory.decodeResource(getResources(),
                R.drawable.cat);
        Bitmap mb = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m,false);
        canvas.drawBitmap(b, 0,0,null);
        canvas.drawBitmap(mb, b.getWidth(),b.getHeight(),null);
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MyView myView = new MyView(this);
        setContentView(new MyView(this));
    }
}