package labtest.pattrawut.androidthai.in.th.krirkshoppingmall.fragment;

import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import labtest.pattrawut.androidthai.in.th.krirkshoppingmall.R;
import labtest.pattrawut.androidthai.in.th.krirkshoppingmall.ServiceActivity;
import labtest.pattrawut.androidthai.in.th.krirkshoppingmall.utility.GetAllDataByURL;
import labtest.pattrawut.androidthai.in.th.krirkshoppingmall.utility.MyAlert;
import labtest.pattrawut.androidthai.in.th.krirkshoppingmall.utility.MyConstant;

/**
 * Created by Pattrawut on 3/6/2018.
 */

public class MainFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Register Controller
        registerController();
//         Login Controller
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText userEdtText = getView().findViewById(R.id.edtID);
                EditText passwordEdiText = getView().findViewById(R.id.edtPassword);

                String userString = userEdtText.getText().toString().trim();
                String passwordString = passwordEdiText.getText().toString().trim();

                if (userString.isEmpty() || passwordString.isEmpty()) {
//                    Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.title_have_space),
                            getString(R.string.message_have_space));
                }else {
//                    No Space
                    try {

                        MyConstant myConstant = new MyConstant();
                        Boolean statusAboolean = true;
                        GetAllDataByURL getAllDataByURL = new GetAllDataByURL(getActivity());
                        getAllDataByURL.execute(myConstant.getURLAddUserString());

                        String jsonString = getAllDataByURL.get();
                        Log.d("27MarchV1","JSON ==>" + jsonString);

                        JSONArray jsonArray =new JSONArray(jsonString);

                        String[] columnString = myConstant.getColumnUser();
                        String[]  loginSting = new String[columnString.length];

                        for (int i = 0; i<jsonArray.length(); i+=1) {

                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            if (userString.equals(jsonObject.getString(columnString[2]))){

                                statusAboolean = false;
                                for (int i1=0; i1<columnString.length; i1+=1) {
                                    loginSting[i1] = jsonObject.getString(columnString[i1]);
                                }
                            }// if

                        } //

                        if (statusAboolean){
//                            User False
                            MyAlert myAlert = new MyAlert(getActivity());
                            myAlert.myDialog("User False",
                                    "No This User in my Database");
                        }else if (passwordString.equals(loginSting[3])) {
//                            Password
                            Toast.makeText(getActivity(), "Welcome" + loginSting[1],
                                    Toast.LENGTH_SHORT).show();

//                            Move to ServiceActivity
                            Intent intent = new Intent(getActivity(), ServiceActivity.class);
                            intent.putExtra("Login", loginSting);
                            startActivity(intent);
                            getActivity().finish();
                        }else {
//                            Password False
                            MyAlert myAlert = new MyAlert(getActivity());
                            myAlert.myDialog("Password False",
                                    "Paease Try Again Password False");
                        }

                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                } // IF


            }
        });


    }   // End Main Method

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtNewRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Replace Fragment
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, new RegisterFragment())
                        .commit();
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;

    }
}
