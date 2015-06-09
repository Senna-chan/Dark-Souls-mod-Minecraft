package starglas.dsremake.common.animations.Deadsapsprout;

import starglas.dsremake.common.MCACommonLibrary.animation.*;
import starglas.dsremake.common.MCACommonLibrary.math.*;

public class ChannelIdle extends Channel {
	public ChannelIdle(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame0 = new KeyFrame();
frame0.modelRenderersRotations.put("leaf3", new Quaternion(0.0F, 1.0F, 0.0F, -4.371139E-8F));
frame0.modelRenderersRotations.put("leaf1", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("leaf2", new Quaternion(0.0F, 0.70710677F, 0.0F, 0.70710677F));
frame0.modelRenderersRotations.put("leaf4", new Quaternion(0.0F, -0.70710677F, 0.0F, 0.70710677F));
frame0.modelRenderersTranslations.put("leaf3", new Vector3f(5.0F, 0.0F, 1.0F));
frame0.modelRenderersTranslations.put("leaf1", new Vector3f(1.0F, 0.0F, 3.0F));
frame0.modelRenderersTranslations.put("leaf2", new Vector3f(4.0F, 0.0F, 4.0F));
frame0.modelRenderersTranslations.put("leaf4", new Vector3f(2.0F, 0.0F, 0.0F));
keyFrames.put(0, frame0);

KeyFrame frame19 = new KeyFrame();
frame19.modelRenderersRotations.put("leaf3", new Quaternion(0.0F, -0.9238795F, 0.0F, 0.38268343F));
frame19.modelRenderersRotations.put("leaf1", new Quaternion(0.0F, 0.38268346F, 0.0F, 0.9238795F));
frame19.modelRenderersRotations.put("leaf2", new Quaternion(0.0F, 0.9238795F, 0.0F, 0.38268343F));
frame19.modelRenderersRotations.put("leaf4", new Quaternion(0.0F, -0.38268346F, 0.0F, 0.9238795F));
frame19.modelRenderersTranslations.put("leaf3", new Vector3f(4.0F, 0.0F, 0.0F));
frame19.modelRenderersTranslations.put("leaf1", new Vector3f(2.0F, 0.0F, 4.0F));
frame19.modelRenderersTranslations.put("leaf2", new Vector3f(5.0F, 0.0F, 3.0F));
frame19.modelRenderersTranslations.put("leaf4", new Vector3f(1.0F, 0.0F, 1.0F));
keyFrames.put(19, frame19);

KeyFrame frame39 = new KeyFrame();
frame39.modelRenderersRotations.put("leaf3", new Quaternion(0.0F, -0.70710677F, 0.0F, 0.70710677F));
frame39.modelRenderersRotations.put("leaf1", new Quaternion(0.0F, 0.70710677F, 0.0F, 0.70710677F));
frame39.modelRenderersRotations.put("leaf2", new Quaternion(0.0F, 1.0F, 0.0F, -4.371139E-8F));
frame39.modelRenderersRotations.put("leaf4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame39.modelRenderersTranslations.put("leaf3", new Vector3f(2.0F, 0.0F, 0.0F));
frame39.modelRenderersTranslations.put("leaf1", new Vector3f(4.0F, 0.0F, 4.0F));
frame39.modelRenderersTranslations.put("leaf2", new Vector3f(5.0F, 0.0F, 1.0F));
frame39.modelRenderersTranslations.put("leaf4", new Vector3f(1.0F, 0.0F, 3.0F));
keyFrames.put(39, frame39);

}
}