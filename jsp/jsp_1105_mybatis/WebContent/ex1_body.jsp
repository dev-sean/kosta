<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@include file="ex1_top.jsp"%>
<article>
			<header>
				<h2>여기는 웹페이지 영역1</h2>
			</header>

			<p>Apps provide multiple entry points Android apps are built as a
				combination of distinct components that can be invoked individually.
				For instance, an individual activity provides a single screen for a
				user interface, and a service independently performs work in the
				background. From one component you can start another component using
				an intent. You can even start a component in a different app, such
				an activity in a maps app to show an address. This model provides
				multiple entry points for a single app and allows any app to behave
				as a user's "default" for an action that other apps may invoke.</p>
			<section>
				<header>
					<h2>여기는 웹페이지 영역2</h2>
				</header>
				<p>Apps adapt to different devices Android provides an adaptive
					app framework that allows you to provide unique resources for
					different device configurations. For example, you can create
					different XML layout files for different screen sizes and the
					system determines which layout to apply based on the current
					device's screen size. You can query the availability of device
					features at runtime if any app features require specific hardware
					such as a camera. If necessary, you can also declare features your
					app requires so app markets such as Google Play Store do not allow
					installation on devices that do not support that feature.</p>
			</section>
		</article>
<%@include file="ex1_bottom.jsp"%>