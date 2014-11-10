package com.example.paint;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawingView extends View {
	
	private final int paintColor = Color.BLACK;
	private Paint paint;
	// private Bitmap mField = null;
	// private Canvas myCanvas;
	
	private Map<Integer, Path> pathMap;
	
	public DrawingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFocusable(true);
		setFocusableInTouchMode(true);
		setupPaint();
		pathMap = new HashMap<Integer, Path>();
	}

	private void setupPaint() {
		paint = new Paint();
		paint.setColor(paintColor);
		paint.setAntiAlias(true);
		paint.setStrokeWidth(5);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setStrokeCap(Paint.Cap.ROUND);

//		Path path = new Path();
//		pathMap.put(paintColor, path);
		/*
		 * Optimize redrawing by caching the bitmap
		View dv = new View(getContext());
		dv = (DrawingView) findViewById(R.id.myDrawingView);
		mField = Bitmap.createBitmap(100, 100, null);
		Toast.makeText(getContext(), "" + dv.getWidth() + " x " +dv.getHeight()  , Toast.LENGTH_SHORT).show();

		myCanvas = new Canvas(mField);
		*/
	}

	@Override
	protected void onDraw(Canvas canvas) {

		
		for (Path path : pathMap.values()) {
			canvas.drawPath(path, paint);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		Path currentPath = getCurrentPath();
		// TODO: Dirty hack
		paint.setColor(PaintActivity.currentColor);
		
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
		if (pathMap.containsKey(PaintActivity.currentColor)) {
			currentPath = pathMap.get(PaintActivity.currentColor);
		} else {
			currentPath = new Path();
			pathMap.put(PaintActivity.currentColor, currentPath);
		}
		return currentPath;
	}
	
	  
	  

}
