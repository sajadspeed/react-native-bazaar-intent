import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-bazaar-intent' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const BazaarIntent = NativeModules.BazaarIntent  ? NativeModules.BazaarIntent  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function details(packagename: string): void {
	return BazaarIntent.details(packagename);
}

export function comments(packagename: string): void {
	return BazaarIntent.comments(packagename);
}

export function developerApps(developerId: string): void {
	return BazaarIntent.developerApps(developerId);
}

export function userLogin(): void {
	return BazaarIntent.userLogin();
}