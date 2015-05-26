package yourModPackage.common.animations.Eldermushan;

import yourModPackage.common.MCACommonLibrary.animation.*;
import yourModPackage.common.MCACommonLibrary.math.*;

public class ChannelWalk extends Channel {
	public ChannelWalk(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame0 = new KeyFrame();
frame0.modelRenderersRotations.put("leftleg", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersRotations.put("rightleg", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame0.modelRenderersTranslations.put("leftleg", new Vector3f(1.0F, -31.0F, -7.0F));
frame0.modelRenderersTranslations.put("rightleg", new Vector3f(-9.0F, -31.0F, -7.0F));
keyFrames.put(0, frame0);

KeyFrame frame20 = new KeyFrame();
frame20.modelRenderersRotations.put("leftleg", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame20.modelRenderersRotations.put("rightleg", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame20.modelRenderersTranslations.put("leftleg", new Vector3f(1.0F, -31.0F, -7.0F));
frame20.modelRenderersTranslations.put("rightleg", new Vector3f(-9.0F, -31.0F, -7.0F));
keyFrames.put(20, frame20);

KeyFrame frame39 = new KeyFrame();
frame39.modelRenderersRotations.put("leftleg", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame39.modelRenderersRotations.put("rightleg", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
frame39.modelRenderersTranslations.put("leftleg", new Vector3f(1.0F, -31.0F, -7.0F));
frame39.modelRenderersTranslations.put("rightleg", new Vector3f(-9.0F, -31.0F, -7.0F));
keyFrames.put(39, frame39);

KeyFrame frame10 = new KeyFrame();
frame10.modelRenderersRotations.put("leftleg", new Quaternion(-0.25038F, 0.0F, 0.0F, 0.96814764F));
frame10.modelRenderersRotations.put("rightleg", new Quaternion(0.25038F, 0.0F, 0.0F, 0.96814764F));
frame10.modelRenderersTranslations.put("leftleg", new Vector3f(1.0F, -31.0F, 2.0F));
frame10.modelRenderersTranslations.put("rightleg", new Vector3f(-9.0F, -27.0F, -14.0F));
keyFrames.put(10, frame10);

KeyFrame frame29 = new KeyFrame();
frame29.modelRenderersRotations.put("leftleg", new Quaternion(0.25038F, 0.0F, 0.0F, 0.96814764F));
frame29.modelRenderersRotations.put("rightleg", new Quaternion(-0.25038F, 0.0F, 0.0F, 0.96814764F));
frame29.modelRenderersTranslations.put("leftleg", new Vector3f(1.0F, -27.0F, -14.0F));
frame29.modelRenderersTranslations.put("rightleg", new Vector3f(-9.0F, -31.0F, 2.0F));
keyFrames.put(29, frame29);

}
}