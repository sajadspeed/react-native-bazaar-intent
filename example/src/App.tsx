import * as React from 'react';

import { StyleSheet, View, Text, Button } from 'react-native';
import { comments, details, developerApps, userLogin } from 'react-native-bazaar-intent';

export default function App() {
  return (
    <View style={styles.container}>
      <Button onPress={()=> details("com.complexcode.accounting")} title="details" />
	  <Button onPress={()=> comments("com.complexcode.accounting")} title="comments" />
	  <Button onPress={()=> developerApps("887533115439")} title="developerApps" />
	  <Button onPress={()=> userLogin()} title="userLogin" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
