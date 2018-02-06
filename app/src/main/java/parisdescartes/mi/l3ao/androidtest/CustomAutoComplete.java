package parisdescartes.mi.l3ao.androidtest;

import android.content.Context;
import android.widget.Button;

import java.util.ArrayList;

public class CustomAutoComplete extends android.support.v7.widget.AppCompatAutoCompleteTextView {
    private ArrayList<Button> autocompleteProposalButtons;
    public CustomAutoComplete(Context context, ArrayList<Button> buttons)
    {
        super(context);
        autocompleteProposalButtons = buttons;
    }

    @Override
    public void onFilterComplete(int count) {

    }
}
