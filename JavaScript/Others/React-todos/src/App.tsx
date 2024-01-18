import './App.css';
import React, {useState} from 'react';
import {TodoTable} from './Components/TodoTable';
import {NewTodoForm} from './Components/NewTodoForm';

export const App = () => {

  const[showAddTodoForm, setShowAddTodoForm] = useState(false);

  // Destructuring the array using (todos values, setting the values -> from useState)
  const [todos, setTodos ] = useState( [
    {rowNumber:1, rowDescription:'Water Plants', rowAssigned:'User two'},
    {rowNumber:2, rowDescription:'Make something', rowAssigned:'User three'},
  ]
  )

  const addTodo = (Description: string, Assigned: string) => {
    let rowNumber=0;
    if(todos.length > 0){
      //simply grabs the row number of the last element and adds 1 to it
      rowNumber= todos[todos.length -1].rowNumber+1;
    }
    else{
      rowNumber=1;
    }
    const newTodo = {
      rowNumber: rowNumber,
      rowDescription: Description,
      rowAssigned: Assigned
    }
    setTodos(todos=> [...todos, newTodo]);
    
  }

  const deleteTodo = (deleteTodoRowNumber: number) =>{
    let filtered = todos.filter(function(value){
      return value.rowNumber !== deleteTodoRowNumber;
    });
    setTodos(filtered);
  }

  return (
    <div className='mt-5 container'>
      <div className='card'>
        <div className='card-header'>
          Your Todo's
        </div>
        <div className='card-body'>
          <TodoTable todos={todos} deleteTodo={deleteTodo}/>
          {/* If we use addTodo() the function will go off at render time */}
          {/* Sets true to false and false to true */}
          <button className='btn btn-primary' onClick={()=> setShowAddTodoForm(!showAddTodoForm)}>
            {/* Sets button value to which makes sense */}

            {showAddTodoForm? 'Close Todo' : 'New Todo'}
            </button>

          {/* Using conditional Render here   */}
          {showAddTodoForm && 
            <NewTodoForm addTodo={addTodo}/>  
          }  
          
        </div>
      </div>
    </div>
  );
}