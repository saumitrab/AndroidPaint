package com.example.paint;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class BrushSizeSelector extends DialogFragment {
	
	public interface BrushSizeSelectorListener {
		void onSelectingBrushSize(int brushSize);
	}

	public BrushSizeSelector() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.brush_size_selecteor, container);
		
		Button btnBrushSize5 = new Button(getActivity());
		btnBrushSize5 = (Button) view.findViewById(R.id.btnBrushSize5);
		btnBrushSize5.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				BrushSizeSelectorListener listener = (BrushSizeSelectorListener) getActivity();
		            listener.onSelectingBrushSize(5);
		            dismiss();			
			}
		});
		
		Button btnBrushSize10 = new Button(getActivity());
		btnBrushSize10 = (Button) view.findViewById(R.id.btnBrushSize10);
		btnBrushSize10.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				BrushSizeSelectorListener listener = (BrushSizeSelectorListener) getActivity();
		            listener.onSelectingBrushSize(10);
		            dismiss();			
			}
		});
		
		Button btnBrushSize15 = new Button(getActivity());
		btnBrushSize15 = (Button) view.findViewById(R.id.btnBrushSize15);
		btnBrushSize15.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				BrushSizeSelectorListener listener = (BrushSizeSelectorListener) getActivity();
		            listener.onSelectingBrushSize(15);
		            dismiss();			
			}
		});


		
		return view;
	}
	
	private void onSelectingBrushSize(int i) {
		// TODO Auto-generated method stub
	}

}
