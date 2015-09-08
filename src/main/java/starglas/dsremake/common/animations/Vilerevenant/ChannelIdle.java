package starglas.dsremake.common.animations.Vilerevenant;

import starglas.dsremake.common.MCACommonLibrary.animation.Channel;
import starglas.dsremake.common.MCACommonLibrary.animation.KeyFrame;
import starglas.dsremake.common.MCACommonLibrary.math.Quaternion;
import starglas.dsremake.common.MCACommonLibrary.math.Vector3f;

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

		KeyFrame frame9 = new KeyFrame();
		frame9.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, 0.70710677F, 0.70710677F));
		frame9.modelRenderersTranslations.put("core", new Vector3f(1.0F, 8.0F, 0.0F));
		keyFrames.put(9, frame9);

		KeyFrame frame19 = new KeyFrame();
		frame19.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, 0.9238795F, 0.38268343F));
		frame19.modelRenderersTranslations.put("core", new Vector3f(2.0F, 10.0F, 0.0F));
		keyFrames.put(19, frame19);

		KeyFrame frame29 = new KeyFrame();
		frame29.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, 1.0F, -4.371139E-8F));
		frame29.modelRenderersTranslations.put("core", new Vector3f(1.0F, 12.0F, 0.0F));
		keyFrames.put(29, frame29);

		KeyFrame frame39 = new KeyFrame();
		frame39.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, -0.9238795F, 0.38268343F));
		frame39.modelRenderersTranslations.put("core", new Vector3f(-1.0F, 13.0F, 0.0F));
		keyFrames.put(39, frame39);

		KeyFrame frame49 = new KeyFrame();
		frame49.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, -0.70710677F, 0.70710677F));
		frame49.modelRenderersTranslations.put("core", new Vector3f(-3.0F, 12.0F, 0.0F));
		keyFrames.put(49, frame49);

		KeyFrame frame59 = new KeyFrame();
		frame59.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, -0.38268346F, 0.9238795F));
		frame59.modelRenderersTranslations.put("core", new Vector3f(-4.0F, 10.0F, 0.0F));
		keyFrames.put(59, frame59);

		KeyFrame frame69 = new KeyFrame();
		frame69.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
		frame69.modelRenderersTranslations.put("core", new Vector3f(-3.0F, 8.0F, 0.0F));
		keyFrames.put(70, frame69);

		KeyFrame frame79 = new KeyFrame();
		frame79.modelRenderersRotations.put("core", new Quaternion(0.0F, 0.0F, 0.38268346F, 0.9238795F));
		frame79.modelRenderersTranslations.put("core", new Vector3f(-1.0F, 7.0F, 0.0F));
		keyFrames.put(79, frame79);

	}
}