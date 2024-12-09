import { useState } from 'react'
import './App.css'
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';
import Task from './utils/task';

let taskId = 0;

function App() {
  const [tname, setTname] = useState("");
  const [tdesc, setTdesc] = useState("");
  const [tpriority, setTpriority] = useState(-1);
  const [newTasks, setNewTasks] = useState([]);
  const [inProgressTasks, setInProgressTasks] = useState([]);
  const [completedTasks, setCompletedTasks] = useState([]);
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const addTask = () => {
    if(tname === "" || tdesc === "" || tpriority == -1){
      alert("Enter proper task title,description,and priority");
      return;
    }
    newTasks.push({
      taskId:taskId,
      tname:tname,
      tdesc:tdesc,
      tpriority:tpriority
    });
    setNewTasks(newTasks);
    handleClose();
  }

  return (
    <>
      <nav>
          <p>My Task Manager</p>
          <button variant="primary" onClick={handleOpen}>
            Add a new Task
          </button>
      </nav>
      <Modal open={open} onClose={handleClose}>
        <Box id="modalStyle">
          <p>Please enter your task below</p>
          <input type='text' placeholder='Enter title of your task' onKeyUp={(event) =>{setTname(event.target.value);}}></input>
          <input type='text' placeholder='Enter description of your task' onKeyUp={(event) =>{setTdesc(event.target.value);}}></input>
          <div>
            <div>
                <label>Priority</label>
                <input type="radio" value="0" name="taskPriority" onChange={() => setTpriority(2)}></input>
                <label>High</label>
                <input type="radio" value="1" name="taskPriority" onChange={() => setTpriority(1)}></input>
                <label>Medium</label>
                <input type="radio" value="2" name="taskPriority" onChange={() => setTpriority(0)}></input>
                <label>Low</label>
            </div>
          </div>
          <div>
            <button onClick={addTask}>Save Task</button>
            <button onClick={handleClose}>Cancel</button>
          </div>
        </Box>
      </Modal>
      <div id="taskSection">
        <div className="taskCol">
          <p className="colHeading">New Task</p>
          <div className="taskItems">
            {/* <Task title={"Title of the Task"} desc={"Hello Hello"} priority={1} newTasks={newTasks} inProgressTasks={inProgressTasks} completedTasks={completedTasks} /> */}
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={1} />
            {newTasks.map((task) => <Task id={task.taskId} title={task.tname} desc={task.tdesc} priority={task.tpriority} />)}
          </div>
        </div>
        <div className="taskCol">
          <p className="colHeading">In Progress</p>
          <div className="taskItems">
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={1} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
          </div>
        </div>
        <div className="taskCol">
          <p className="colHeading">Completed</p>
          <div className="taskItems">
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={1} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
          </div>
        </div>
      </div>
    </>
  )
}
export default App;
