package a498.capstone;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ericprits on 2018-02-08.
 */

public class ParseDeleteDialog extends DialogFragment {
    ParseDeleteDialogListener mListener;

    public interface ParseDeleteDialogListener{
        void onDialogNegativeClick(DialogFragment dialog);
    }

    public ParseDeleteDialog(){
    }

    public void setListener(ParseDeleteDialog.ParseDeleteDialogListener context){
        this.mListener = context;
    }




    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Bundle bundle = getArguments();
        final String Name = bundle.getString("Name");
        final String Quantity = bundle.getString("Quantity");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final LinearLayout lay = (LinearLayout) inflater.inflate(R.layout.dialog_parsedelete, null);
        final TextView NameView = lay.findViewById(R.id.itemName);
        final TextView QuantityView = lay.findViewById(R.id.quantityAmount);

        builder.setView(lay)
                .setNegativeButton(R.string.summarydialog_delete, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Bundle bundle = new Bundle();
                        bundle.putString("Name", Name);
                        mListener.onDialogNegativeClick(ParseDeleteDialog.this);
                    }
                });


        NameView.setText(Name);
        QuantityView.setText(Quantity);

        return builder.create();
    }


}
