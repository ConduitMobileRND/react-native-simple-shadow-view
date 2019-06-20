
# react-native-simple-shadow-view

## Getting started

`$ npm install react-native-simple-shadow-view --save`

### Mostly automatic installation

`$ react-native link react-native-simple-shadow-view`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-shadow` and add `RNShadow.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNShadow.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.como.RNTShadowView.ShadowViewPackage;` to the imports at the top of the file
  - Add `new ShadowViewPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-simple-shadow-view'
  	project(':react-native-simple-shadow-view').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-simple-shadow-view/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      implementation project(':react-native-simple-shadow-view')
  	```
4. Insert the following lines inside the defaultConfig block in `android/app/build.gradle`:
  	```
      renderscriptTargetApi 18
      renderscriptSupportModeEnabled true
  	```


## Usage

Set shadow parameters to the ShadowView just as you use shadows in iOS. it will appear on android same as on iOS.

```javascript
import React, { Component } from 'react';
import ShadowView from 'react-native-simple-shadow-view'

class MyView extends Component {

	render() {
		return (
			<ShadowView
					style={{
						width: 100,
						height: 100,
						shadowColor: 'black',
						shadowOpacity: 1,
						shadowRadius: 20,
						shadowOffset: { width: 0, height: 0 },
						backgroundColor: 'rgba(0,255,0,0.5)',
					}}
				>
				... Texts / Views / etc ...
				</ShadowView>
			);
	}

export default MyView;
```
