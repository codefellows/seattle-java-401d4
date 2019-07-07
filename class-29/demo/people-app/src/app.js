import React from 'react';
import './app.css';

function App() {

  const API = 'http://localhost:3000/people';
  // const API = 'http://localhost:5000/api/v1/customers';

  return (
    <div className="App">
      <form action={API} method="post" encType="multipart/form-data">
        <label>
          <input name="name" placeholder="name" />
        </label>
        <label>
          <div>Are You Old?</div>
          <input name="old" type="radio" value="true" /><span>Yes</span>
          <input name="old" type="radio" value="false" /><span>No</span>
        </label>
        <label>
          <span>Upload Image</span>
          <input name="file" type="file" />
        </label>
        <button>Save</button>
      </form>
    </div>
  );
}

export default App;
