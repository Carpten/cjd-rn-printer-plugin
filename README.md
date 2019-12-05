
# react-native-printer

## Getting started

`$ npm install react-native-printer --save`

### Mostly automatic installation

`$ react-native link react-native-printer`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.chuangjiangx.printer.RNPrinterPackage;` to the imports at the top of the file
  - Add `new RNPrinterPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-printer'
  	project(':react-native-printer').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-printer/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-printer')
  	```


## Usage
```javascript
import RNPrinter from 'react-native-printer';

// TODO: What to do with the module?
RNPrinter;
```
  