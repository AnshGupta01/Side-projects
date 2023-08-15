import React,{useState} from "react"

export const NewTodoForm: React.FC<{addTodo: Function}> = (props) => {

    const[Description, setDescription] = useState('');
    const[Assigned, setAssigned] = useState('');

    const submitTodo = () => {
        if(Description !== '' && Assigned !== ''){
            props.addTodo(Description, Assigned);
            setDescription('');
            setAssigned('');
        }
    }

    return(
        <div className="mt-5">
            <form>
                <div className="mb -3">
                    <label className="form-label">Assigned</label>
                    <input 
                    type="text" 
                    className="form-control" 
                    required
                    onChange={e => setAssigned(e.target.value)}
                    value={Assigned}
                    ></input>
                </div>
                <div className="mb -3">
                    <label className="form-label">Description</label>
                    <textarea className="form-control" 
                    rows={3} 
                    required
                    onChange={e => setDescription(e.target.value)}
                    value={Description}>
                    </textarea>
                </div>
                <button type="button" 
                    className="btn btn-primary mt-3" 
                    onClick={submitTodo}>
                    Add Todo
                </button>
            </form>
        </div>
    )
}