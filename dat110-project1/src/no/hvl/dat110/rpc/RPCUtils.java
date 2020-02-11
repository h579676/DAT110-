package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.getBytes().length + 1];
		byte[] strTab = str.getBytes();
		
		
		encoded[0] = rpcid;
		
		
		for(int i = 0; i < str.getBytes().length; i++) {
			encoded[i+1] = strTab[i];
		}

		// TODO: marshall RPC identifier and string into byte array

//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {
	
		String decoded = new String(Arrays.copyOfRange(data, 1, data.length));

		// TODO: unmarshall String contained in data into decoded

//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];

		
		encoded[0] = rpcid;
		// TODO: marshall RPC identifier in case of void type

//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {
		return;
		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		
		
		byte[] encoded = new byte[5];
		
		encoded[0] = rpcid;
		
		ByteBuffer bb = ByteBuffer.allocate(4);
		byte[] tmp = bb.putInt(x).array();
		
		System.arraycopy(tmp, 0, encoded, 1, tmp.length);
	
		
		// TODO: marshall RPC identifier and string into byte array

//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		
		
		
		
		byte[] tmp = Arrays.copyOfRange(data, 1, data.length);

		
		ByteBuffer bb = ByteBuffer.wrap(tmp);
		int decoded = bb.getInt();
		
		
		
		// TODO: unmarshall integer contained in data

//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return decoded;

	}
}
