import Sidebar from '@/components/Sidebar';
import React from 'react';

function App() {
  const scheduleData = [
    { subjectCode: 'CSEN1001', subject: 'DBMS', section: 'A', roomNo: '501', timings: '10:00 - 11:00' },
    { subjectCode: 'CSEN1001', subject: 'DBMS', section: 'A', roomNo: '501', timings: '10:00 - 11:00' },
    { subjectCode: 'CSEN1001', subject: 'DBMS', section: 'A', roomNo: '501', timings: '10:00 - 11:00' },
    { subjectCode: 'CSEN1001', subject: 'DBMS', section: 'A', roomNo: '501', timings: '10:00 - 11:00' },
    { subjectCode: 'CSEN1001', subject: 'DBMS', section: 'A', roomNo: '501', timings: '10:00 - 11:00' },
    { subjectCode: 'CSEN1001', subject: 'DBMS', section: 'A', roomNo: '501', timings: '10:00 - 11:00' },
  ];

  return (
    <div className="p-8 flex">
      <Sidebar />
      <div className="w-full overflow-hidden rounded-lg shadow-lg mt-24">
        <table className="w-full bg-blue-700 text-white">
          <thead>
            <tr>
              <th className="head">Subject Code</th>
              <th className="head">Subject</th>
              <th className="head">Section</th>
              <th className="head">Room No</th>
              <th className="head">Timings</th>
            </tr>
          </thead>
          <tbody>
            {scheduleData.map((item, index) => (
              <tr key={index} className="even:bg-blue-700 odd:bg-blue-600">
                <td>{item.subjectCode}</td>
                <td>{item.subject}</td>
                <td>{item.section}</td>
                <td>{item.roomNo}</td>
                <td>{item.timings}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default App;
