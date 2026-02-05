import { useEffect, useState } from 'react'

const API_BASE = import.meta.env.VITE_API_BASE || 'https://student-api-production-bcac.up.railway.app'

export default function App() {
  const [students, setStudents] = useState([])
  const [addName, setAddName] = useState('')
  const [addScore, setAddScore] = useState('')
  const [updName, setUpdName] = useState('')
  const [updScore, setUpdScore] = useState('')
  const [delName, setDelName] = useState('')

  async function loadStudents() {
    const res = await fetch(`${API_BASE}/students`)
    const data = await res.json()
    setStudents(data)
  }

  async function addStudent() {
    const score = Number(addScore)
    if (!addName.trim() || Number.isNaN(score)) return alert('请输入姓名和分数')
    await fetch(`${API_BASE}/students`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name: addName.trim(), score })
    })
    setAddName('')
    setAddScore('')
    await loadStudents()
  }

  async function updateScore() {
    const score = Number(updScore)
    if (!updName.trim() || Number.isNaN(score)) return alert('请输入姓名和新分数')
    await fetch(`${API_BASE}/students/${encodeURIComponent(updName.trim())}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ score })
    })
    setUpdName('')
    setUpdScore('')
    await loadStudents()
  }

  async function deleteByName() {
    if (!delName.trim()) return alert('请输入姓名')
    await fetch(`${API_BASE}/students/${encodeURIComponent(delName.trim())}`, { method: 'DELETE' })
    setDelName('')
    await loadStudents()
  }

  async function clearAll() {
    await fetch(`${API_BASE}/students`, { method: 'DELETE' })
    await loadStudents()
  }

  useEffect(() => {
    loadStudents()
  }, [])

  return (
    <div className="page">
      <div className="bg-orb orb-1" />
      <div className="bg-orb orb-2" />
      <div className="bg-orb orb-3" />

      <div className="wrap">
        <header className="hero">
          <p className="eyebrow">Student Console</p>
          <h1>学生管理（React）</h1>
          <p className="subtitle">轻量级 CRUD 面板，快速管理学生信息与成绩。</p>
        </header>

        <div className="card card-hero">
          <div className="row">
            <input placeholder="姓名" value={addName} onChange={e => setAddName(e.target.value)} />
            <input placeholder="分数" type="number" value={addScore} onChange={e => setAddScore(e.target.value)} />
            <button onClick={addStudent}>新增</button>
            <button className="secondary" onClick={loadStudents}>刷新列表</button>
            <button className="danger" onClick={clearAll}>清空</button>
          </div>
          <p className="muted">提示：姓名非唯一，可能会影响多条记录。</p>
        </div>

        <div className="card">
          <div className="row">
            <input placeholder="要更新的姓名" value={updName} onChange={e => setUpdName(e.target.value)} />
            <input placeholder="新分数" type="number" value={updScore} onChange={e => setUpdScore(e.target.value)} />
            <button onClick={updateScore}>更新分数</button>
          </div>
        </div>

        <div className="card">
          <div className="row">
            <input placeholder="要删除的姓名" value={delName} onChange={e => setDelName(e.target.value)} />
            <button className="danger" onClick={deleteByName}>删除</button>
          </div>
        </div>

        <div className="card table-card">
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>分数</th>
              </tr>
            </thead>
            <tbody>
              {students.map(s => (
                <tr key={s.id}>
                  <td>{s.id}</td>
                  <td>{s.name}</td>
                  <td>{s.score}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  )
}
