package yourModPackage.common.animations.Vilerevenant;

import yourModPackage.common.MCACommonLibrary.animation.*;
import yourModPackage.common.MCACommonLibrary.math.*;

public class ChannelIdle extends Channel {
	public ChannelIdle(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame0 = new KeyFrame();
frame0.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, 0.38268346F, 0.9238795F));
frame0.modelRenderersTranslations.put("core", new Vector3f(-1.0F, 7.0F, 0.0F));
keyFrames.put(0, frame0);

KeyFrame frame49 = new KeyFrame();
frame49.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, -0.70710677F, 0.70710677F));
frame49.modelRenderersTranslations.put("core", new Vector3f(-3.0F, 12.0F, 0.0F));
keyFrames.put(49, frame49);

KeyFrame frame20 = new KeyFrame();
frame20.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, 0.9238795F, 0.38268343F));
frame20.modelRenderersTranslations.put("core", new Vector3f(2.0F, 10.0F, 0.0F));
keyFrames.put(20, frame20);

KeyFrame frame70 = new KeyFrame();
frame70.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame70.modelRenderersTranslations.put("core", new Vector3f(-3.0F, 8.0F, 0.0F));
keyFrames.put(70, frame70);

KeyFrame frame39 = new KeyFrame();
frame39.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, -0.9238795F, 0.38268343F));
frame39.modelRenderersTranslations.put("core", new Vector3f(-1.0F, 13.0F, 0.0F));
keyFrames.put(39, frame39);

KeyFrame frame9 = new KeyFrame();
frame9.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, 0.70710677F, 0.70710677F));
frame9.modelRenderersTranslations.put("core", new Vector3f(1.0F, 8.0F, 0.0F));
keyFrames.put(9, frame9);

KeyFrame frame60 = new KeyFrame();
frame60.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, -0.38268346F, 0.9238795F));
frame60.modelRenderersTranslations.put("core", new Vector3f(-4.0F, 10.0F, 0.0F));
keyFrames.put(60, frame60);

KeyFrame frame30 = new KeyFrame();
frame30.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, 1.0F, -4.371139E-8F));
frame30.modelRenderersTranslations.put("core", new Vector3f(1.0F, 12.0F, 0.0F));
keyFrames.put(30, frame30);

KeyFrame frame79 = new KeyFrame();
frame79.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, 0.38268346F, 0.9238795F));
frame79.modelRenderersTranslations.put("core", new Vector3f(-1.0F, 7.0F, 0.0F));
keyFrames.put(79, frame79);

}
}