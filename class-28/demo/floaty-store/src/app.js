import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './app.scss';

import mockData from './mock.json';

const API = 'http://172.16.0.219:5000/api/v1/customers'

function People() {

  const [people, setPeople] = useState([]);
  const [counter, setCount] = useState(0);

  const _getPeople = () => {
    // setPeople(mockData)
    // fetch from brook
    fetch( API, {
      mode:'cors',
    })
    .then( data => data.json() )
    .then( ppl => setPeople(ppl) )
    .catch( console.error );

  };

  const _toggleStatus = (e) => {
    e.preventDefault();
    let id = e.target.id;
    // setPeople( people.map( (person) =>
    //   person.id !== id ? person : {...person, vip:!person.vip}
    // ));

    // patch to Brooks api
    fetch( `${API}/${id}/status`, {
      mode:'cors',
      method: 'PATCH'
    })
    .then(data => data.json())
    .then(person => {
      setPeople( people.map( (entry) => {
          return entry.id === id ? person : entry;
        }
      ));
    })
    .catch( console.error );

  };

  useEffect(_getPeople, []);

  return (
    <ul>
      {people.map( (person) =>
        <li className={`vip-${person.vip}`} key={person.id}>
          <details>
            <summary>
              <span>{person.name}</span>
              <span id={person.id} onClick={_toggleStatus}>{person.vip.toString()}</span>

            </summary>
            <History history={person.history} />
          </details>
        </li>
      )}
    </ul>
  )
}

function History(props) {
  let history = props.history || [];
  return (
    <section>
      {history.map( (item,idx) =>
        <>
          <span>{item.itemName}</span>
          <span>{item.price}</span>
        </>
      )}
    </section>
  )
}

function App() {
  return (
    <>
      <header>Floaty Store</header>
      <main>
        <People />
      </main>
      <footer>&copy; 2019 Brookr</footer>
      </>
  );
}

export default App;
