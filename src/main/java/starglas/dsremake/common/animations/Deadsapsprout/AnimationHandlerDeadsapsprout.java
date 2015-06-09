package starglas.dsremake.common.animations.Deadsapsprout;

import java.util.HashMap;

import starglas.dsremake.common.MCACommonLibrary.IMCAnimatedEntity;
import starglas.dsremake.common.MCACommonLibrary.animation.AnimationHandler;
import starglas.dsremake.common.MCACommonLibrary.animation.Channel;

public class AnimationHandlerDeadsapsprout extends AnimationHandler {
	/** Map with all the animations. */
	public static HashMap<String, Channel> animChannels = new HashMap<String, Channel>();
	static {
		animChannels.put("Idle", new ChannelIdle("Idle", 120.0F, 40, Channel.LOOP));
		animChannels.put("FlyAway", new ChannelIdle("FlyAway", 500.0F, 40, Channel.LOOP));
	}

	public AnimationHandlerDeadsapsprout(IMCAnimatedEntity entity) {
		super(entity);
	}

	@Override
	public void activateAnimation(String name, float startingFrame) {
		super.activateAnimation(animChannels, name, startingFrame);
	}

	@Override
	public void stopAnimation(String name) {
		super.stopAnimation(animChannels, name);
	}

	@Override
	public void fireAnimationEventClientSide(Channel anim, float prevFrame, float frame) {
	}

	@Override
	public void fireAnimationEventServerSide(Channel anim, float prevFrame, float frame) {
	}
}