package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {


		
		byte[] request = RPCUtils.marshallString(RPCID, message);
		byte[] response = rpcclient.call(request);
		
		
		
		System.out.println(RPCUtils.unmarshallString(response));
		
//		unmarshalling for write RPC method
		
		// TODO
		// implement marshalling, call and unmarshalling for write RPC method

//		throw new UnsupportedOperationException(TODO.method());
	}
}