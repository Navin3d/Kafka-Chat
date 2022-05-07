import React, { useState } from 'react';
import SockJsClient from 'react-stomp';
import axios from "axios";

import './App.css';
import Input from './components/Input/Input';
import Messages from './components/Messages/Messages';


const SOCKET_URL = 'http://localhost:8080/kafka-chat/';

const App = () => {
  const [messages, setMessages] = useState([])

  let onConnected = () => {
    console.log("Connected!!")
  }

  let onMessageReceived = (msg) => {
    console.log('New Message Received!!', msg);
    setMessages((prev) => [...prev, msg]);

    console.log("MSG: ", messages);
  }

  let onSendMessage = async (msgText) => {
    await axios.get(`http://localhost:8080/message/${msgText}/send`).then(res => {
      console.log('Sent', res);
    }).catch(err => {
      console.log('Error Occured while sending message to api');
    })
  }

  return (
    <div className="App">
      
          <>
            <SockJsClient
              url={SOCKET_URL}
              topics={['/topic/group']}
              onConnect={onConnected}
              onDisconnect={console.log("Disconnected!")}
              onMessage={msg => onMessageReceived(msg)}
              debug={false}
            />
            <Messages
              messages={messages}
            />
            <Input onSendMessage={onSendMessage} />
          </>
    
    </div>
  )
}

export default App;