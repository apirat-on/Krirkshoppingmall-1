package labtest.pattrawut.androidthai.in.th.krirkshoppingmall.utility;

import android.provider.FontsContract;

/**
 * Created by playn on 3/27/2018.
 */

public class MyConstant {
    //    Adout URG
    private String URLAddUserString = "http://androidthai.in.th/kri/addDataUng.php";
    private  String URLGetAllUserString ="http://androidthai.in.th/kri/getAllData.php";

    private String[] columnUser = new String[]{"id", "Name", "User", "Password", "Mode"};


    public String getURLGetAllUserString() {
        return URLGetAllUserString;
    }

    public String[] getColumnUser() {
        return columnUser;
    }

    public String getURLAddUserString() {
        return URLAddUserString;
    }
}// Main Class
