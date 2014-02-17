package com.wedy.screenmute;
	
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class NotificationiconPatcher implements IXposedHookLoadPackage {


    	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {

		if (!lpparam.packageName.equals("com.android.systemui"))
			return;

		try {
			XposedHelpers.findAndHookMethod(
					"com.android.systemui.statusbar.policy.NetworkController",
					lpparam.classLoader,
					"updateSimIcon",
					XC_MethodReplacement.DO_NOTHING
			);
		} catch (Throwable t) {
			XposedBridge.log(t.getMessage());
		}

	};

}