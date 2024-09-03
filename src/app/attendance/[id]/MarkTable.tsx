import * as React from 'react';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Checkbox from '@mui/material/Checkbox';

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: "#003c73",
    color: theme.palette.common.white,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  '&:nth-of-type(odd)': {
    backgroundColor: "#00509A",
  },
  // hide last border
  '&:last-child td, &:last-child th': {
    border: 0,
  },
}));

function createData(
  name: string,
  regNo: string,
  attended: string,
  percentage: number,
  status: boolean,
) {
  return { name, regNo, attended, percentage, status };
}

const rows = [
createData('Vanshika Vemula', 'VU22CSEN0101128', '12/20', 80, true),
createData('Vanshika Vemula', 'VU22CSEN0101128', '12/20', 80, true),
createData('Vanshika Vemula', 'VU22CSEN0101128', '12/20', 80, true),
createData('Vanshika Vemula', 'VU22CSEN0101128', '12/20', 80, true),
createData('Vanshika Vemula', 'VU22CSEN0101128', '12/20', 80, true),
createData('Vanshika Vemula', 'VU22CSEN0101128', '12/20', 80, true),
];

export default function CustomizedTables() {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 700 }} aria-label="customized table">
        <TableHead>
          <TableRow>
            <StyledTableCell align="left">Name</StyledTableCell>
            <StyledTableCell align="left">Reg No</StyledTableCell>
            <StyledTableCell align="left">Attended</StyledTableCell>
            <StyledTableCell align="left">Percentage</StyledTableCell>
            <StyledTableCell align="left">Present | Absent</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <StyledTableRow key={row.name}>
              <StyledTableCell component="th" scope="row">
                {row.name}
              </StyledTableCell>
              <StyledTableCell align="left">{row.regNo}</StyledTableCell>
              <StyledTableCell align="left">{row.attended}</StyledTableCell>
              <StyledTableCell align="left">{row.percentage}</StyledTableCell>
              <StyledTableCell align="left" className="flex justify-center items-center">
                <Checkbox defaultChecked />
                <Checkbox />
              </StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}