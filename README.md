# Multi-client Chat Server

### Description:
Multi-client Chat Server is a Java-based server application that allows real-time text-based communication among multiple clients using TCP sockets. This chat server employs Thread Pools to efficiently manage multiple client connections concurrently. This allows numerous clients to connect, chat, and interact seamlessly without overwhelming system resources.

To use the chat server, follow these steps:
- Connecting: Connect to the server at port 8046. Upon connecting to the server, the client will be prompted to insert their name. After providing the name, they can begin chatting with others.
- Chatting: Clients can send messages by typing them and pressing Enter. Messages will be broadcasted to all connected clients.
- Exiting: To exit the chat and disconnect from the server, clients can simply type "/exit" and press Enter.

### Languages and Libraries:
This project is developed in Java. It leverages Java's socket library for network communication over the TCP (Transmission Control Protocol) protocol and utilizes Thread Pools to efficiently handle concurrent client connections.

### About:
This project was created during the Academia de Código bootcamp, between May and August 2023.
