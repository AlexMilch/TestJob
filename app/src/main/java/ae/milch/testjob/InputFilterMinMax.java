package ae.milch.testjob;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Toast;

public class InputFilterMinMax implements InputFilter {
    private int min, max;
    private String message;
    public Context context;

    public InputFilterMinMax(int min, int max, String message, Context context) {
        this.min = min;
        this.max = max;
        this.message = message;
        this.context = context;
    }

    public InputFilterMinMax(String min, String max, String message, Context context) {
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
        this.message = message;
        this.context = context;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            int input = Integer.parseInt(dest.toString() + source.toString());
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) {

        }
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
        return "";
    }

    private boolean isInRange(int a, int b, int c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}