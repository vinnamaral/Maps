package au.com.vinnamaral.maps;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class OverlayUtil extends ItemizedOverlay<OverlayItem>{
	
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	Context ctx;

	public OverlayUtil(Drawable marker) {
		super(boundCenterBottom(marker));
	}
	
	public OverlayUtil(Drawable marker, Context context) {
		super(boundCenterBottom(marker));
		ctx = context;
	}
	
	public void addOverlay(OverlayItem overlay){
		mOverlays.add(overlay);
		populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		return mOverlays.get(i);
	}

	@Override
	public int size() {
		return mOverlays.size();
	}
	
	@Override
	protected boolean onTap(int i) {
		OverlayItem item = mOverlays.get(i);
		AlertDialog.Builder dialog = new AlertDialog.Builder(ctx);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return true;
	}

}
