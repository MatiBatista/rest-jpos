package org.jpos.rest.Handler;

import org.eclipse.jetty.io.Content;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.Callback;

public class HelloWordHandler extends Handler.Abstract{
    private String page = """
            <html>
                <body>
                    <h1>Hello world</h1>
                </body>
            </html>
            """;
    @Override
    public boolean handle(Request request, Response response, Callback callback) throws Exception {
        sendMessage(page,response,callback);
        return true;
    }

    private void sendMessage(String message, Response resp, Callback callback) {
        Content.Sink.write(resp, true, message, callback);
    }
}
