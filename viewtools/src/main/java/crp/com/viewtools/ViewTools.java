package crp.com.viewtools;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import static android.content.Context.VIBRATOR_SERVICE;

public class ViewTools {
    public ViewTools(Activity activity) {
        this.activity = activity;
    }

    private Activity activity;

    //"#89216B"
    public void statusBarColor(String color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }



    public void vibrateView(int num) {

        //doc_pick_icon.setHapticFeedbackEnabled( true );doc_pick_icon.performHapticFeedback(200);
        Vibrator myVib;
        myVib = (Vibrator) activity.getSystemService(VIBRATOR_SERVICE);
        myVib.vibrate(num);
    }

    public void hideSoftKeyboard() {

        if (activity != null) {
            InputMethodManager inputMethodManager =
                    (InputMethodManager) activity.getSystemService(
                            Activity.INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }


    public void editTextImageView(final EditText editText, final ImageView imageView, final int colorClick,final int colorHint) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        editText.setBackgroundTintList(ColorStateList.valueOf(colorClick));
                        imageView.setImageTintList(ColorStateList.valueOf(colorClick));//sexy color change
                    }

                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        editText.setBackgroundTintList(ColorStateList.valueOf(colorHint));
                        imageView.setImageTintList(ColorStateList.valueOf(colorHint));//sexy color change
                    }

                }
            }
        });

    }
    public void editTextDesign(final EditText editText, final int colorClick,final int colorHint) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        editText.setBackgroundTintList(ColorStateList.valueOf(colorClick));
                    }

                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        editText.setBackgroundTintList(ColorStateList.valueOf(colorHint));
                    }

                }
            }
        });

    }

}
