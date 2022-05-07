import React, { useState } from 'react';

const Input = ({ onSendMessage }) => {
    const [text, setText] = useState("")

    let onChange = (e) => {
        setText(e.target.value)
    }

    let onSubmit = () => {
        setText("")
        onSendMessage(text);
    }

    return (
        <div className="message-input">
            <input
                className="inputField"
                label="Type your message here..."
                placeholder="Enter your message and press ENTER"
                onChange={e => onChange(e)}
                margin="normal"
                value={text}
                onKeyPress={event => {
                    if (event.key === 'Enter') {
                        onSubmit(text);
                    }
                }}
                style={{ height: "30px", width: "80%" }}
            />

            <button variant="contained" color="primary" onClick={onSubmit}>
                Send
            </button>
        </div>
    );
}


export default Input