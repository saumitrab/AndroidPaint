package com.example.paint;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

public class DrawingView extends View {
	// private Bitmap mField = null;
	// private Canvas myCanvas;
	
	// TODO: Convert this to a new class	
	public static Map<Pair<Integer, Integer>, Pair<Path, Paint>> attribPathPaintMap;
	
	
	public DrawingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFocusable(true);
		setFocusableInTouchMode(true);
		attribPathPaintMap = new HashMap<Pair<Integer, Integer>, Pair<Path, Paint>>();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		for (Pair<Path, Paint> pairPathPaint : attribPathPaintMap.values()) {
			canvas.drawPath(pairPathPaint.first, pairPathPaint.second);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		Path currentPath = getCurrentPath();
		// TODO: Dirty hack
		//paint.setColor(PaintActivity.currentColor);
		
		switch(event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			currentPath.moveTo(event.getX(), event.getY());
			break;
			
		case MotionEvent.ACTION_MOVE:
			currentPath.lineTo(event.getX(), event.getY());
			break;
			
		default:
			return false;
		}
		
		postInvalidate();
		
		// have we consumed the event?
		return true;
	}
	
	protected Path getCurrentPath() {
		Path currentPath = null;
		
		Pair<Integer, Integer> attrib = new Pair<Integer, Integer>(PaintActivity.currentColor, PaintActivity.currentBrushSize);
		
		if (attribPathPaintMap.containsKey(attrib)) {
			Pair<Path, Paint> pairPathPaint = attribPathPaintMap.get(attrib);
			currentPath = pairPathPaint.first;
		} else {
			Paint paint = new Paint();
			paint.setColor(PaintActivity.currentColor);
			paint.setAntiAlias(true);
			paint.setStrokeWidth(PaintActivity.currentBrushSize);
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeJoin(Paint.Join.ROUND);
			paint.setStrokeCap(Paint.Cap.ROUND);
			
			currentPath = new Path();
			
			Pair<Path, Paint> pairPathPaint = new Pair<Path, Paint>(currentPath, paint);
			attribPathPaintMap.put(attrib, pairPathPaint);
		}
		return currentPath;
	}
	
	@SuppressWarnings("unused")
	private void initPaint(int color) {
	
//		Path path = new Path();
//		pathMap.put(paintColor, path);
		/*
		 * Optimize redrawing by caching the bitmap

		mField = Bitmap.createBitmap(100, 100, null);
		Toast.makeText(getContext(), "" + dv.getWidth() + " x " +dv.getHeight()  , Toast.LENGTH_SHORT).show();

		myCanvas = new Canvas(mField);
		*/
	}
  
	  

}
