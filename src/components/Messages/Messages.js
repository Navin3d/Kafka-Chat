import React from 'react'

const Messages = ({ messages }) => {

    let renderMessage = (message) => {
        // const { sender, content, color } = message;

        const className = true ? "Messages-message currentUser" : "Messages-message";
        return (
            <li className={className}>
                <span
                    className="avatar"
                    style={{ backgroundColor: "rgb(0, 255, 0)" }}
                />
                <div className="Message-content">
                    {/* <div className="username">
                        {sender}
                    </div> */}
                    <div className="text">{message}</div>
                </div>
            </li>
        );
    };

    return (
        <ul className="messages-list">
            {messages.map(msg => renderMessage(msg.message))}
        </ul>
    )
}


export default Messages