package com.example.androidgraphview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyGraphView extends View {
	
	Paint paintBackground;
	Paint paintGraph;
	Context myContext;
	
	class Item{
		int x;
		int y;
		
		Item(int nx, int ny){
			x = nx;
			y = ny;
		}
	}
	
	private List<Item> itemList = new ArrayList<Item>();

	public MyGraphView(Context context) {
		super(context);
		init(context);
	}

	public MyGraphView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public MyGraphView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}
	
	private void init(Context c){
		myContext = c;
		
		paintBackground = new Paint();
		paintBackground.setStyle(Paint.Style.FILL);
		paintBackground.setColor(Color.BLACK);
		
		paintGraph = new Paint();
		paintGraph.setStyle(Paint.Style.STROKE);
		paintGraph.setColor(Color.WHITE);
		paintGraph.setStrokeWidth(3);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int w = MeasureSpec.getSize(widthMeasureSpec);
		int h = MeasureSpec.getSize(heightMeasureSpec);
		setMeasuredDimension(w, h);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawRect(0, 0, getWidth(), getHeight(), paintBackground);
		
		for (Item it : itemList) {
			int invY = getHeight() - it.y;
			canvas.drawPoint(it.x, invY, paintGraph);
		}
	}

	void addItem(int tx, int ty){
		itemList.add(new Item(tx, ty));
	}
	
}
