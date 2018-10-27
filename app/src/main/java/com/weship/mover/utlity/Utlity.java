package com.weship.mover.utlity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weship.mover.R;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utlity {
    private static Utlity context;
    public static int val;
    public static String Is_it_drivable;
    //db variables
    private static SharedPreferences local_db;
    private static SharedPreferences.Editor tbl_user;
    //type for validations
    public static String type_name = "name";
    public static String type_email = "email";
    public static String type_mobile = "mobile";
    public static String type_password = "pass";
    public static String type_confirm_password = "con_pass";
    public static String type_match = "match";

    // to show  full  screen activity
    public static void full_screen(Activity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    // to save user  detail

    public static void user_db(Activity activity, HashMap<String, String> user_info) {
        local_db = activity.getSharedPreferences(activity.getString(R.string.user_db), Context.MODE_PRIVATE);
        tbl_user = local_db.edit();
        for (Object key : user_info.keySet()) {
            String value = (String) user_info.get(key);
            tbl_user.putString(key.toString(), value);
            Log.d("key>>>", key.toString());
        }
        tbl_user.apply();
    }

    //to get user info
    public static String get_detail(Activity activity, String key) {
        local_db = activity.getSharedPreferences(activity.getString(R.string.user_db), Context.MODE_PRIVATE);
        return local_db.getString(key, "");
    }

    //to clear user  db
    public static void clear_db(Activity activity) {
        local_db = activity.getSharedPreferences(activity.getString(R.string.user_db), Context.MODE_PRIVATE);
        tbl_user = local_db.edit();
        tbl_user.clear();
        tbl_user.apply();
    }

    //to set user is login
    public static void set_login(Activity activity, boolean value) {
        local_db = activity.getSharedPreferences(activity.getString(R.string.login_db), Context.MODE_PRIVATE);
        tbl_user = local_db.edit();
        tbl_user.putBoolean(activity.getString(R.string.is_login), value);
        tbl_user.apply();
    }

    // to check is  user login  or not
    public static boolean get_login(Activity activity) {
        local_db = activity.getSharedPreferences(activity.getString(R.string.login_db), Context.MODE_PRIVATE);
        return local_db.getBoolean(activity.getString(R.string.is_login), false);
    }

    //to check is  network is available or not
    public static boolean is_online(Activity activity) {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
            //we are connected to a network
            connected = true;
        else
            connected = false;
        return connected;
    }

    //to show toast
    public static void show_toast(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    //to check text is empty
    public static boolean is_empty(String value) {
        return TextUtils.isEmpty(value);
    }

    //to check to value is  equal
    public static boolean is_equal(String value1, String value2) {
        boolean is_valid = false;
        if (value1.equals(value2)) {
            is_valid = true;
        }
        return is_valid;
    }

    //to check  email  is valid or not

    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        Boolean value = matcher.matches();
        Log.d("email validtion", "==" + value);
        if (value) {
            return true;

        } else {
            return false;

        }


    }

    //force close keyboard
    public static void hide_keyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        assert imm != null;
        if (imm.isActive()) {
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0); // hide
        } else {
            imm.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY); // show
        }
    }//end metho

    //to show error
    public static Dialog show_error(Activity activity, String msg) {
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCancelable(false);
        TextView txt_msg = (TextView) dialog.findViewById(R.id.msg);
        txt_msg.setText(msg);
        LinearLayout done = (LinearLayout) dialog.findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        return dialog;
    }

    // to check user validations
    public static boolean is_valid(Activity activity, LinkedHashMap<String, String> values) {
        boolean is_validate = false;
        for (Object key : values.keySet()) {
            String value = (String) values.get(key);
            String type = key.toString();
            Dialog dialog;
            if (type.equalsIgnoreCase("name")) {
                if (Utlity.is_empty(value)) {
                    dialog = show_error(activity, activity.getString(R.string.name_empty_msg));
                    dialog.show();
                    is_validate = false;
                    break;
                } else {
                    is_validate = true;
                }
            } else if (type.equalsIgnoreCase("mobile")) {
                if (Utlity.is_empty(value)) {
                    dialog = show_error(activity, activity.getString(R.string.mobile_empty_msg));
                    dialog.show();
                    is_validate = false;
                    break;
                } else {
                    is_validate = true;
                }
            } else if (type.equalsIgnoreCase("email")) {
                if (!Utlity.isValidEmail(value)) {
                    dialog = show_error(activity, activity.getString(R.string.email_empty_msg));
                    dialog.show();
                    is_validate = false;
                    break;
                } else {
                    is_validate = true;
                }
            } else if (type.equalsIgnoreCase("pass")) {
                if (Utlity.is_empty(value)) {
                    dialog = show_error(activity, activity.getString(R.string.pass_empty_msg));
                    dialog.show();
                    is_validate = false;
                    break;
                } else {
                    is_validate = true;
                }
            } else if (type.equalsIgnoreCase("con_pass")) {
                if (Utlity.is_empty(value)) {
                    dialog = show_error(activity, activity.getString(R.string.pass_empty_msg));
                    dialog.show();
                    is_validate = false;
                    break;
                } else {
                    is_validate = true;
                }
            } else if (type.equalsIgnoreCase("match")) {
                StringTokenizer stringTokenizer = new StringTokenizer(value, "match");
                String pass = stringTokenizer.nextToken();
                String confirm = stringTokenizer.nextToken();
                if (Utlity.is_empty(value) || !Utlity.is_equal(pass, confirm)) {
                    dialog = show_error(activity, activity.getString(R.string.not_match));
                    dialog.show();
                    is_validate = false;
                    break;
                } else {
                    is_validate = true;
                }
            }
        }
        return is_validate;
    }
    public static int increase(String value){
        val = Integer.parseInt(value);
        Log.d("increase",String.valueOf(val));
        val++;
        return val;
    }
    public static int decrease(String value){
        val = Integer.parseInt(value);
        Log.d("Deacrease",String.valueOf(val));
        if (val==0)
            Log.d("sorry","its already Zero");
        else
            val--;
        return val;
    }

}
