package starglas.dsremake.common.animations.Mimicchest;

import starglas.dsremake.common.MCACommonLibrary.animation.*;
import starglas.dsremake.common.MCACommonLibrary.math.*;

public class ChannelOpen extends Channel {
	public ChannelOpen(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame0 = new KeyFrame();
frame0.modelRenderersRotations.put("Shape15", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Shape11", new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame0.modelRenderersRotations.put("Shape19", new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame0.modelRenderersRotations.put("Shape10", new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame0.modelRenderersRotations.put("Shape20", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Shape18", new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame0.modelRenderersRotations.put("Shape17", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Shape14", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Shape16", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("Shape12", new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame0.modelRenderersRotations.put("Shape13", new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame0.modelRenderersTranslations.put("Shape15", new Vector3f(-25.0F, 10.5F, 10.5F));
frame0.modelRenderersTranslations.put("Shape11", new Vector3f(21.0F, 2.0F, 19.0F));
frame0.modelRenderersTranslations.put("Shape19", new Vector3f(-21.0F, 8.0F, 23.0F));
frame0.modelRenderersTranslations.put("Shape10", new Vector3f(21.0F, 2.0F, 10.0F));
frame0.modelRenderersTranslations.put("Shape20", new Vector3f(-21.0F, 9.5F, 9.5F));
frame0.modelRenderersTranslations.put("Shape18", new Vector3f(-21.0F, 2.0F, 10.0F));
frame0.modelRenderersTranslations.put("Shape17", new Vector3f(-25.0F, 2.0F, 16.0F));
frame0.modelRenderersTranslations.put("Shape14", new Vector3f(21.0F, 10.5F, 10.5F));
frame0.modelRenderersTranslations.put("Shape16", new Vector3f(21.0F, 2.0F, 15.0F));
frame0.modelRenderersTranslations.put("Shape12", new Vector3f(-24.0F, 2.0F, 19.0F));
frame0.modelRenderersTranslations.put("Shape13", new Vector3f(-24.0F, 2.0F, 10.0F));
keyFrames.put(0, frame0);

KeyFrame frame19 = new KeyFrame();
frame19.modelRenderersRotations.put("Shape15", new Quaternion(-0.37336144F, 0.0F, 0.0F, 0.927686F));
frame19.modelRenderersRotations.put("Shape11", new Quaternion(0.010069043F, 0.0F, 0.0F, 0.9999493F));
frame19.modelRenderersRotations.put("Shape19", new Quaternion(0.010069043F, 0.0F, 0.0F, 0.9999493F));
frame19.modelRenderersRotations.put("Shape10", new Quaternion(0.010069043F, 0.0F, 0.0F, 0.9999493F));
frame19.modelRenderersRotations.put("Shape20", new Quaternion(-0.37336144F, 0.0F, 0.0F, 0.927686F));
frame19.modelRenderersRotations.put("Shape18", new Quaternion(0.010069043F, 0.0F, 0.0F, 0.9999493F));
frame19.modelRenderersRotations.put("Shape17", new Quaternion(-0.37336144F, 0.0F, 0.0F, 0.927686F));
frame19.modelRenderersRotations.put("Shape14", new Quaternion(-0.37336144F, 0.0F, 0.0F, 0.927686F));
frame19.modelRenderersRotations.put("Shape16", new Quaternion(-0.37336144F, 0.0F, 0.0F, 0.927686F));
frame19.modelRenderersRotations.put("Shape12", new Quaternion(0.010069043F, 0.0F, 0.0F, 0.9999493F));
frame19.modelRenderersRotations.put("Shape13", new Quaternion(0.010069043F, 0.0F, 0.0F, 0.9999493F));
frame19.modelRenderersTranslations.put("Shape15", new Vector3f(-25.0F, 19.4F, -2.7F));
frame19.modelRenderersTranslations.put("Shape11", new Vector3f(21.0F, 19.2F, 9.8F));
frame19.modelRenderersTranslations.put("Shape19", new Vector3f(-21.0F, 26.7F, 8.9F));
frame19.modelRenderersTranslations.put("Shape10", new Vector3f(21.0F, 12.8F, 3.2F));
frame19.modelRenderersTranslations.put("Shape20", new Vector3f(-21.0F, 18.4F, -2.7F));
frame19.modelRenderersTranslations.put("Shape18", new Vector3f(-21.0F, 12.3F, 3.2F));
frame19.modelRenderersTranslations.put("Shape17", new Vector3f(-25.0F, 18.2F, 8.3F));
frame19.modelRenderersTranslations.put("Shape14", new Vector3f(21.0F, 19.4F, -2.7F));
frame19.modelRenderersTranslations.put("Shape16", new Vector3f(21.0F, 18.2F, 7.8F));
frame19.modelRenderersTranslations.put("Shape12", new Vector3f(-24.0F, 19.2F, 9.8F));
frame19.modelRenderersTranslations.put("Shape13", new Vector3f(-24.0F, 12.8F, 3.2F));
keyFrames.put(19, frame19);

KeyFrame frame39 = new KeyFrame();
frame39.modelRenderersRotations.put("Shape15", new Quaternion(-0.70710677F, 0.0F, 0.0F, 0.70710677F));
frame39.modelRenderersRotations.put("Shape11", new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame39.modelRenderersRotations.put("Shape19", new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame39.modelRenderersRotations.put("Shape10", new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame39.modelRenderersRotations.put("Shape20", new Quaternion(-0.70710677F, 0.0F, 0.0F, 0.70710677F));
frame39.modelRenderersRotations.put("Shape18", new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame39.modelRenderersRotations.put("Shape17", new Quaternion(-0.70710677F, 0.0F, 0.0F, 0.70710677F));
frame39.modelRenderersRotations.put("Shape14", new Quaternion(-0.70710677F, 0.0F, 0.0F, 0.70710677F));
frame39.modelRenderersRotations.put("Shape16", new Quaternion(-0.70710677F, 0.0F, 0.0F, 0.70710677F));
frame39.modelRenderersRotations.put("Shape12", new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame39.modelRenderersRotations.put("Shape13", new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F));
frame39.modelRenderersTranslations.put("Shape15", new Vector3f(-25.0F, 16.5F, -14.5F));
frame39.modelRenderersTranslations.put("Shape11", new Vector3f(21.0F, 25.0F, -6.0F));
frame39.modelRenderersTranslations.put("Shape19", new Vector3f(-21.0F, 30.0F, -12.0F));
frame39.modelRenderersTranslations.put("Shape10", new Vector3f(21.0F, 16.0F, -6.0F));
frame39.modelRenderersTranslations.put("Shape20", new Vector3f(-21.0F, 15.5F, -13.5F));
frame39.modelRenderersTranslations.put("Shape18", new Vector3f(-21.0F, 15.0F, -6.0F));
frame39.modelRenderersTranslations.put("Shape17", new Vector3f(-25.0F, 23.0F, -6.0F));
frame39.modelRenderersTranslations.put("Shape14", new Vector3f(21.0F, 16.5F, -14.5F));
frame39.modelRenderersTranslations.put("Shape16", new Vector3f(21.0F, 23.0F, -6.0F));
frame39.modelRenderersTranslations.put("Shape12", new Vector3f(-24.0F, 25.0F, -6.0F));
frame39.modelRenderersTranslations.put("Shape13", new Vector3f(-24.0F, 16.0F, -6.0F));
keyFrames.put(39, frame39);

}
}