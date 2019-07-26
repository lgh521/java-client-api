package com.marklogic.client.test.dbfunction.positive;

// IMPORTANT: Do not edit. This file is generated.

import com.marklogic.client.io.Format;
import java.io.Reader;


import com.marklogic.client.DatabaseClient;
import com.marklogic.client.io.marker.JSONWriteHandle;

import com.marklogic.client.impl.BaseProxy;

/**
 * Provides a set of operations on the database server
 */
public interface MimetypeBundle {
    /**
     * Creates a MimetypeBundle object for executing operations on the database server.
     *
     * The DatabaseClientFactory class can create the DatabaseClient parameter. A single
     * client object can be used for any number of requests and in multiple threads.
     *
     * @param db	provides a client for communicating with the database server
     * @return	an object for executing database operations
     */
    static MimetypeBundle on(DatabaseClient db) {
      return on(db, null);
    }
    /**
     * Creates a MimetypeBundle object for executing operations on the database server.
     *
     * The DatabaseClientFactory class can create the DatabaseClient parameter. A single
     * client object can be used for any number of requests and in multiple threads.
     *
     * The service declaration uses a custom implementation of the same service instead
     * of the default implementation of the service by specifying an endpoint directory
     * in the modules database with the implementation. A service.json file with the
     * declaration can be read with FileHandle or a string serialization of the JSON
     * declaration with StringHandle.
     *
     * @param db	provides a client for communicating with the database server
     * @param serviceDeclaration	substitutes a custom implementation of the service
     * @return	an object for executing database operations
     */
    static MimetypeBundle on(DatabaseClient db, JSONWriteHandle serviceDeclaration) {
        final class MimetypeBundleImpl implements MimetypeBundle {
            private BaseProxy baseProxy;

            private MimetypeBundleImpl(DatabaseClient dbClient, JSONWriteHandle servDecl) {
                baseProxy = new BaseProxy(dbClient, "/dbf/test/mimetype/", servDecl);
            }

            @Override
            public Reader apiReader(String endpointDirectory, String functionName) {
              return BaseProxy.JsonDocumentType.toReader(
                baseProxy
                .request("apiReader.sjs", BaseProxy.ParameterValuesKind.MULTIPLE_ATOMICS)
                .withSession()
                .withParams(
                    BaseProxy.atomicParam("endpointDirectory", false, BaseProxy.StringType.fromString(endpointDirectory)),
                    BaseProxy.atomicParam("functionName", false, BaseProxy.StringType.fromString(functionName)))
                .withMethod("POST")
                .responseSingle(true, Format.JSON)
                );
            }

        }

        return new MimetypeBundleImpl(db, serviceDeclaration);
    }

  /**
   * Invokes the apiReader operation on the database server
   *
   * @param endpointDirectory	provides input
   * @param functionName	provides input
   * @return	as output
   */
    Reader apiReader(String endpointDirectory, String functionName);

}