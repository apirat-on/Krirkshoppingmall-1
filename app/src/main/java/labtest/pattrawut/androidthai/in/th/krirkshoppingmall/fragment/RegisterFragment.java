package labtest.pattrawut.androidthai.in.th.krirkshoppingmall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import labtest.pattrawut.androidthai.in.th.krirkshoppingmall.MainActivity;
import labtest.pattrawut.androidthai.in.th.krirkshoppingmall.R;
import labtest.pattrawut.androidthai.in.th.krirkshoppingmall.utility.MyAlert;

/**
 * Created by Pattrawut on 3/6/2018.
 */

public class RegisterFragment extends Fragment {

//    Explier
    private String nameString, userString, passwordString, modeString;
    private boolean aBoolean =true;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create toolbar
        createToolbar();

//        Radio Controller
        radioController();

    }   // Main Method

    private void radioController() {
        RadioGroup radioGroup =getView().findViewById(R.id.ragMode);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                aBoolean = false;
                switch (i) {
                    case R.id.ragOwner:
                        modeString="OwnerShop";
                        break;
                    case R.id.ragCustomer:
                        modeString ="Customer";
                        break;
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.itemupload) {
            uploadtoServer();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void uploadtoServer() {

//        Get Value From Edittext
        EditText nameEditText = getView().findViewById(R.id.edtName);
        EditText userEditText = getView().findViewById(R.id.edtUser);
        EditText passwordEditText = getView().findViewById(R.id.edtPassword);

        nameString = nameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

//        Check Space
        if (nameString.isEmpty() || userString.isEmpty() || passwordString.isEmpty()) {
//            Have Space
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.myDialog(getString(R.string.title_have_space),
                    getString(R.string.message_have_space));

        } else if (aBoolean) {
//            Non Choose Mode
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.myDialog("Non Choose Mode", "Please Choose Mode");
        }else {
//            Choose Mode OK
        }

    }   // uploadtoServer

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_register,menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    private void createToolbar() {

        setHasOptionsMenu(true);

        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.register));
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.message_have_space));

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
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
