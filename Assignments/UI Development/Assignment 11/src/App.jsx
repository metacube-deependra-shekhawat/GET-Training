import { useState } from 'react'
import './App.css'
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';
import Task from './utils/task';

let TASK_ID = 0;

function App() {
  const [tname, setTname] = useState("");
  const [tdesc, setTdesc] = useState("");
  const [tpriority, setTpriority] = useState(-1);
  const [tasks, setTasks] = useState([]);
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const addTask = () => {
    if(tname === "" || tdesc === "" || tpriority == -1){
      alert("Enter proper task title,description,and priority");
      return;
    }
    tasks.push({
      taskId:TASK_ID,
      tname:tname,
      tdesc:tdesc,
      tpriority:tpriority,
      tstatus: 0
    });
    TASK_ID++;
    handleClose();
    setTname("");
    setTdesc("");
    setTpriority(-1);
    setTasks(tasks);
    console.log(tasks);
  }

  const deleteTask = (id) => {
    console.log(id);
    console.log(tasks);
    const newTasks = tasks.filter((task) => task.taskId !== id);
    console.log(newTasks);
    setTasks(newTasks);
  }

  const updateTask = (updatedTask) => {
        tasks.findIndex((task) => task.index === updatedTask.index);
        const newTasks = tasks.map((task) => {
            if (task.taskId === updatedTask.taskId) {
                return { ...task, tname: updatedTask.title, tdesc: updatedTask.desc, tstatus: updatedTask.status, tpriority: updatedTask.priority };
            }
            return task;
        });
        setTasks(newTasks);
    }

  return (
    <>
      <nav>
          <p>My Task Manager</p>
          <button variant="primary" onClick={handleOpen}>
            <span id="plusSym">+ </span> Add Task
          </button>
      </nav>
      <Modal open={open} onClose={handleClose}>
        <Box id="modalStyle">
          <p>Please enter your task below</p>
          <div className="inputs">
            <label>Title</label>
            <input type='text' placeholder='Enter title of your task' onKeyUp={(event) =>{setTname(event.target.value);}}></input>
            <label>Description</label>
            <input type='text' placeholder='Enter description of your task' onKeyUp={(event) =>{setTdesc(event.target.value);}}></input>
          </div>
          <div>
            <div>
                <label>Priority:</label>
                <span> </span>
                <input type="radio" value="0" name="taskpriority" onChange={() => setTpriority(2)}></input>
                <label>high</label>
                <span> </span>
                <input type="radio" value="1" name="taskpriority" onChange={() => setTpriority(1)}></input>
                <label>medium</label>
                <span> </span>
                <input type="radio" value="2" name="taskpriority" onChange={() => setTpriority(0)}></input>
                <label>low</label>
            </div>
          </div>
          <div>
            <button onClick={addTask}>Save Task</button>
            <span> </span>
            <button onClick={handleClose}>Cancel</button>
          </div>
        </Box>
      </Modal>
      <div id="taskSection">
        <div className="taskCol">
          <p className="colHeading">New Task</p>
          <div className="taskItems">
            {tasks.map((task) => {
              if(task.tstatus === 0)
                 return (<Task id={task.taskId} title={task.tname} desc={task.tdesc} priority={task.tpriority} status={task.tstatus} updateTask={updateTask} deleteTask={deleteTask} />)
            }).reverse()}
          </div>
        </div>
        <div className="taskCol">
          <p className="colHeading">In Progress</p>
          <div className="taskItems">
            {tasks.map((task) => {
              if(task.tstatus === 1)
                return (<Task id={task.taskId} title={task.tname} desc={task.tdesc} priority={task.tpriority} status={task.tstatus} updateTask={updateTask} deleteTask={deleteTask} />)
            }).reverse()}
          </div>
        </div>
        <div className="taskCol">
          <p className="colHeading">Completed</p>
          <div className="taskItems">
            {tasks.map((task) => {
              if(task.tstatus === 2)
                return (<Task id={task.taskId} title={task.tname} desc={task.tdesc} priority={task.tpriority} status={task.tstatus} updateTask={updateTask} deleteTask={deleteTask} />)
            }).reverse()}
          </div>
        </div>
      </div>
    </>
  )
}
export default App;
